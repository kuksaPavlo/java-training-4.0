package example;

import org.testng.annotations.Test;

public class TestClassThree {

    @Test(priority = 5)
    public void setUpProcess5Of5(){
        System.out.println("input the password");
    }
    @Test(priority = 4)
    public void setUpProcess4Of5(){
        System.out.println("select the AP");
    }
    @Test(priority = 3)
    public void setUpProcess3Of5(){
        System.out.println("check the Wi-Fi AP");
    }
    @Test(priority = 2)
    public void setUpProcess2Of5(){
        System.out.println("wait the prompt sound,");
    }
    @Test(priority = 1)
    public void setUpProcess1Of5(){
        System.out.println("Press the setup button,");
    }

    //Press the setup button, wait the prompt sound, check the Wi-Fi AP, select the DUT to the AP, input the password,
}
