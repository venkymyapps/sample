package org.sample.com.util;

public interface ResponseCode {

	String CreateEmployeeSuccessful = "1011";
	String CreateEmployeeFailure = "1012";
	String EmployeeAlreadyExist = "1013";
	String CreateCompanySuccessful = "1021";
	String CreateCompanyFailure = "1022";
	String CompanyAlreadyExist = "1023";	

	String UpdateEmployeeSuccessful = "1111";
	String UpdateEmployeeFailure = "1112";

	String updateEmailIdSuccessful = "1121";
	String updateEmailIdFailure = "1122";

	String updateStatusSuccessful = "1131";
	String updateStatusFailure = "1132";

	String updateExpSuccessful = "1141";
	String updateExpFailure = "1142";
	String getEmpExpSuccessful = "1143";
	String getEmpExpFailure = "1144";

	String getSalarySuccessful = "1211";
	String getSalaryFailure = "1212";

	String getEmployeeSuccessful = "1311";
	String getEmployeeFailure = "1312";

	String deleteEmployeeSuccessful = "1411";
	String deleteEmployeeFailure = "1412";
	
	String CreateCitySuccessful = "1511";
    String CreateCityFailure = "1512";
    String CityAlreadyAdded = "1513";
    
    String ReadCitySuccessful = "1611";
    String ReadCityFailure = "1612";
    
    String RemoveCitySuccessful = "1711";
    String RemoveCityFailure = "1712";
    
    String LocalityAddSuccessful = "1811";
    String LocalityAlreadyExist = "1813";
    String LocalityAddFailure = "1812";
    
    String ReadLocalitySuccessful = "1911";
    String ReadLocalityFailure = "1912";
    
    String updateLocalitySuccessful = "2111";
    String updateLocalityFailure = "2112";
    
    String AddLocationSuccessful = "2211";
    String AddLocationFailure = "2212";
    
    String ReadLocationSuccessful = "2231";
    String ReadLocationFailure = "2232";
    
    String UpdateLocationSuccessful = "2321";
    String UpdateLocationFailure = "2322";
    
    String DeleteLocationSuccessful = "2411";
    String DeleteLocationFailure = "2412";
    
    String invalidData = "9999";
    
    String  EmpNameExist = "1011";
    String EmpNameDoesNotExist = "1012";
    
    String MobileNoExist = "1031";
    String MobileNoDoesNotExist = "1032";
    
    String EmailIDExist = "1021";
    String EmailIdDoesNotExist = "1022";
    
    String ReadCompanySuccessful = "3111";
    String ReadCompanyFailure = "3112";
    
    String RemoveCompanySuccessful = "3121";
    String RemoveCompanyFailure = "3122";
    
    String UpdateCompanySuccessful = "5555";
    String UpdateCompanyFailure = "6666";
}
