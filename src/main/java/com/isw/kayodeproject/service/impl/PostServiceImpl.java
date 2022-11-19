package com.isw.kayodeproject.service.impl;

import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.entity.Post;
import com.isw.kayodeproject.entity.User;
import com.isw.kayodeproject.mapper.PostMapper;
import com.isw.kayodeproject.repository.PostRepository;
import com.isw.kayodeproject.repository.UserRepository;
import com.isw.kayodeproject.service.PostService;
//import com.isw.kayodeproject.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

//    private IdGenerator idGenerator;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
//        this.idGenerator = idGenerator;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto) // same as <<map((post) -> PostMapper.mapToPostDto(post))>>
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostsByUser() {
//        String email = SecurityUtils.getCurrentUser().getUsername();


        // CHANGE THIS!
        String email = "";
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Post> posts = postRepository.findPostsByUser(userId);
        return posts.stream()
                .map((post) -> PostMapper.mapToPostDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
//        String email = SecurityUtils.getCurrentUser().getUsername();


        //CHANGE THIS
        String email = "";
        User user = userRepository.findByEmail(email);
//        String id = idGenerator.createId();
//        postDto.setId(id);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(user);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
        //postRepository is the db
        Post post = postRepository.findById(postId).get();

        //this method returns a postDto type so the post type gotten
        // from the db has to be converted
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePost(PostDto postDto) {
//        String email = SecurityUtils.getCurrentUser().getUsername();

        String email = "";
        User createdBy = userRepository.findByEmail(email);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(createdBy);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostDto findPostByUrl(String postUrl) {

        //from the repo we get a post object
        Post post = postRepository.findByUrl(postUrl).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

}
