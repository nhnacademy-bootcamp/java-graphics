package com.nhnacademy;

import java.awt.Frame;

public class FrameDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. Frame 만들기
        Frame frame = new Frame("FrameDemo01");
        // 2. Frame의 크기를 지정한다.
        frame.setSize(300, 200);
        // 3. Frame을 보여 준다
        frame.setVisible(true);
    }
}