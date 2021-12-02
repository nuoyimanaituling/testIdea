package com.lixiang;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode righNode = new TreeNode(3);
        root.leftNode = leftNode;
        root.rightNode  = righNode;
        Main main = new Main();
        ArrayList<Integer> result = main.Pre(root);
        for ( int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
         System.out.println("hello world");
    }

   static class TreeNode {
        int val ;
        TreeNode leftNode;
        TreeNode rightNode;
      public TreeNode(int val){
            this.val =val;
        }

    }

    public  ArrayList<Integer> Pre(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode xzw =  root;
        while(!stack.isEmpty() || xzw !=null){
            while(xzw != null){
                result.add(xzw.val);
                stack.push(xzw);
                xzw = xzw.leftNode;
            }
            xzw = stack.pop();
            xzw = xzw.rightNode;
        }
        return result;

    }
}