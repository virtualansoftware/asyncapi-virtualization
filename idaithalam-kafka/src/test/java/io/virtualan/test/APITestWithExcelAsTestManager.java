package io.virtualan.test;





public class APITestWithExcelAsTestManager {


  @org.testng.annotations.Test
  public static void execute_workflow() {
    try {
      boolean isSuccess = io.virtualan.idaithalam.core.api.VirtualanTestPlanExecutor.invoke("work-flow.yaml");
      if (!isSuccess) {
        org.testng.Assert.assertTrue(false);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}