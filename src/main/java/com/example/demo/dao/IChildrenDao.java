package com.example.demo.dao;
import com.example.demo.entitys.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IChildrenDao {

	public List<Children> getChildren() throws InterruptedException, ExecutionException;
   
}