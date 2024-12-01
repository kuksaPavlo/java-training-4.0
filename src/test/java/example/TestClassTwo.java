package example;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClassTwo {
    @Parameters({"name", "password"})
    @Test
    public void parameterTest(String name, String password){
        System.out.println("User name " + name);
        System.out.println("User password " + password);
    }
    @DataProvider(name = "SearchData")
    public Object[][] dataSet(){
        return new Object[][]{
                {"Smoke", "5 errors"},
                {"Sanity", "2 errors"},
                {"Extended sanity", "40 errors"}
        };
    }

    @Test(dataProvider = "SearchData")
    public void searchingDataTest(String test, String errors){
        System.out.println("Test " + test + " was found " + errors);
    }
}
