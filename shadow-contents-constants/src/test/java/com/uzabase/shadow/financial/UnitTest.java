package com.uzabase.shadow.financial;

import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung-Vu on 2017/04/17.
 */
public class UnitTest {

    @Tested private Unit unit;
    
    @Test
    public void test() throws Exception {
        
        System.out.println(Unit.get("回"));
    }
}