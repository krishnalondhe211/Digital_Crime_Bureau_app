package com.example.student2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableView {

        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();




            List<String> criminal1 = new ArrayList<String>();
            criminal1.add("Male");
            criminal1.add("25");
            criminal1.add("8600828652");
            criminal1.add("Karad");
            criminal1.add("Murderer");
            criminal1.add("male");


            expandableListDetail.put("Kasab", criminal1);

            return expandableListDetail;
        }
    }
