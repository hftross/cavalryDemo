package testCase;

import annotation.DataSource;
import api.Passport;
import entity.CaseInfo;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import service.ExcelDataSourceService;
import service.RunCaseService;
import service.SetUpTearDown;

/**
 * Created by hzhft on 2019/3/24.
 */
@Listeners
public class demoTest extends SetUpTearDown{
    RunCaseService runCaseService = new RunCaseService();
    @DataSource(dataAddr = "login",methodName = "login")
    @Test(dataProvider = "dataprovider", dataProviderClass = ExcelDataSourceService.class)
    public void testLogin( CaseInfo caseInfo) {
        runCaseService.doSendHttp(caseInfo,"login", Passport.Enum.phoneLoginPost);
    }
}
