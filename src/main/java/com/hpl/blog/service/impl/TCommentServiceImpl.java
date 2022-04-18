package com.hpl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hpl.blog.display.CommentTree;
import com.hpl.blog.entity.TComment;
import com.hpl.blog.mapper.TCommentMapper;
import com.hpl.blog.service.TCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

    @Override
    public List<CommentTree> findAllCommentByBlogId(String blogId) {
        // 找出所有的评论
        QueryWrapper<TComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("blog_id", blogId);
        List<TComment> tComments = baseMapper.selectList(queryWrapper);

        // 构建一个Map<Long, List<CommentTree>> key表示根评论Id， value表示评论下的回复列表
        Map<Long, CommentTree> cache = new HashMap<>();
        Map<Long, CommentTree> rootComment = new HashMap<>();
        Map<Long, List<CommentTree>> map = new HashMap<>();
        for(TComment comment: tComments){
            CommentTree cur = new CommentTree();
            cur.setId(comment.getId());
            cur.setNickName(comment.getNickname());
            cur.setEmail(comment.getEmail());
            cur.setContent(comment.getContent());
            cur.setCreateTime(comment.getCreateTime());

            Long curParentCommentId = comment.getParentCommentId();
            cache.put(comment.getId(), cur);        // 把【评论ID: 评论】的key-value关系 缓存在map中

            // 把回复评论评论与对应的根评论进行连接
            if(curParentCommentId != null){
                if(!map.containsKey(curParentCommentId)){
                    map.put(curParentCommentId, new ArrayList<>());
                }
                List<CommentTree> list = map.get(curParentCommentId);
                list.add(cur);
                map.put(curParentCommentId, list);
            }
            else{
                rootComment.put(comment.getId(), cur);
            }
        }

        // 构建返回类型
        List<CommentTree> ans = new ArrayList<>();
        for(Long rootKey: rootComment.keySet()){
            CommentTree curRootComment = rootComment.get(rootKey);
            List<CommentTree> children = new ArrayList<>();
            searchChildren(curRootComment.getId(), map, children, cache);
            curRootComment.setChildren(children);
            ans.add(curRootComment);
        }
        return ans;
    }

    // 对于当前评论id，查找所有对于当前评论的回复，存储在children中
    private void searchChildren(Long id, Map<Long, List<CommentTree>> map, List<CommentTree> children, Map<Long, CommentTree> cache) {
        if(!map.containsKey(id)) return;
        for(CommentTree cur: map.get(id)){
            cur.setParentNickName(cache.get(id).getNickName());

            CommentTree newChildren = new CommentTree();
            BeanUtils.copyProperties(cur, newChildren);
            children.add(newChildren);
            searchChildren(cur.getId(), map, children, cache);
        }
    }
}
