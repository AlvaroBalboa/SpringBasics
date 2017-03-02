package com.theironyard.novauc;

/**
 * Created by souporman on 3/2/17.
 */
public class Blog {
    String blogPost;

    public Blog(String blogPost) {
        this.blogPost = blogPost;
    }

    public String getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }
}
