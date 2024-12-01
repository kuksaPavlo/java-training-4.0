package example;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestClassOne{
    @BeforeGroups("Box1")
    public void beforeGroups(){
        System.out.println("Before group");
    }
    @AfterGroups("Box1")
    public void afterGroups(){
        System.out.println("After group");
    }


    @Test(groups = "Box1")
    public void testOne(){
        System.out.println("TestOne");
    }
    @Test(groups = "Box1")
    public void testTwo(){
        System.out.println("TestTwo");
    }
    @Test(groups = "Box2", enabled = false)
    public void testThree(){
        System.out.println("TestThree");
    }
}
