package com.csye6225.spring2018;

import com.csye6225.spring2018.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

//import com.csye6225.spring2018
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebControllerTest {

    private Account myAccount;
    private static Logger logger = Logger.getLogger(WebControllerTest.class);

    @Before
    public void setUp() {
        myAccount = new Account();
        myAccount.setPassword("123456");
        logger.info(" set up test test tsestt");
    }

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        Assert.assertEquals(2, a);
        logger.info(" test test tsestt");
        logger.debug("adsasd");
        logger.warn("sample warn message");
        //logger.error("sample error message");

        //System.out.println("  test results is success");
    }

    @Test
    public void TestEncryption() {
       // logger.error("1 sample error message in TestEncryption");

        logger.info("Encryption Test is starting..");


        String hashedPassword = myAccount.passwordEncrption(myAccount.getPassword());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String secondhashedPassword = passwordEncoder.encode(myAccount.getPassword());

        if(hashedPassword.equals(secondhashedPassword))
        {
            logger.info("Something wrong with password hashing test");
            System.out.println("Something wrong with password hashing test");
        }
        else
        {
            logger.debug("Encryption Test is Successfull");
            //System.out.println("Encryption Test is Successfull");
        }
        Assert.assertNotEquals(hashedPassword, secondhashedPassword);

    }

}