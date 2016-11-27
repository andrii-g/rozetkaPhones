//package helper;
//
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebElement;
//
///**
// * Created by User on 24.11.2016.
// */
//public class Helper {
//    public boolean waitForElement(WebElement element) {
//        boolean result = false;
//        int attempts = 0;
//        while(attempts < 10) {
//            try {
//                if (element.isEnabled()){
//                    result = true;
//                    break;
//                }else {
//                    Thread.sleep(1000);
//                }
//            } catch(StaleElementReferenceException e) {
//                System.out.println("Oops! StaleElementReferenceException occured");
//            } catch (InterruptedException e) {
//                System.out.println("Oops! InterruptedException occured");
//            }
//            attempts++;
//        }
//        return result;
//    }
//}
