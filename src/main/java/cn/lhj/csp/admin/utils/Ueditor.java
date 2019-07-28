package cn.lhj.csp.admin.utils;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ueditor implements Serializable{
    private String state; 
    private String url; 
    private String title; 
    private String original; 
}
