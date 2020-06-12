package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.fco.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
