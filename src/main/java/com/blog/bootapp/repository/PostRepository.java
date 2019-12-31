package com.blog.bootapp.repository;

import com.blog.bootapp.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("select e from Post e where  e.Id = :id")
    Post getById(@Param("id") Long id);

    @Query("select e from Post e where LOWER(e.title) like lower(:name) or lower(e.content) like lower(:name)" )
    List<Post> findByTitleLike(String name);

    @Query("select e from Post e where e.Id in(select c.postId from PostCategory c where c.categoryId= :id )")
    List<Post> getPostByCategory(long id);

    @Query("select e from Post e ")
    List<Post> findAll();

    @Query("select e from Post e where e.authorId= :id")
    List<Post> getPostByAuthor(long id);

    @Query("select e from Post e where e.Id in :postIds order by e.createdAt asc")
    Page<Post> findByIdsCAsc(List<Long> postIds,Pageable pageable);

    @Query("select e from Post e where e.Id in :postIds order by e.createdAt desc")
    Page<Post> findByIdsCDesc(List<Long> postIds,Pageable pageable);

    @Query("select e from Post e where e.Id in :postIds order by e.updatedAt asc")
    Page<Post> findByIdsUAsc(List<Long> postIds,Pageable pageable);

    @Query("select e from Post e where e.Id in :postIds order by e.updatedAt desc")
    Page<Post> findByIdsUDesc(List<Long> postIds,Pageable pageable);
}
