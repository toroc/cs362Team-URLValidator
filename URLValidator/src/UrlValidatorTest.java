/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }
  
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   /*Test valid scheme, valid authority, valid port EXPECT TRUE */
	   System.out.println(urlVal.isValid("http://www.amazon.com/"));
	   /*Test valid scheme, authority, port, and valid path EXPECT TRUE*/
	   System.out.println(urlVal.isValid("https://www.amazon.com/index_2_4.html"));
	   /*Test valid scheme, authority, port, path, and valid query EXPECT TRUE*/
	   System.out.println(urlVal.isValid("http://www.amazon.com/t123?action=view"));
	   
	   /*Test valid scheme, INVALID authority, port, and valid path EXPECT FALSE*/
	   System.out.println(urlVal.isValid("https://www.a-.com/index_2_4.html"));
	   /*Test INVALID scheme, valid authority, valid port EXPECT FALSE */
	   System.out.println(urlVal.isValid("hst://www.amazon.com/"));
   }
   
   public void testYourFirstPartition()
   {
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   
   // ----------------- Programming Based Testing -------------
   public void testProgrammic()
   {
      // TODO: Kevin -- This is still a work in progress
	   // TODO: Figure out more valid and invalid schemes
	   // TODO: Figure out more valid and invalid authorities
	   // TODO: Create more tests for port, path, and query
	   // Schema I am testing: scheme+authority+port+path+query
	   // <scheme>://<authority><path>?<query>
	   System.out.println("Running programming based testing...unfinished");
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String url;
	   Boolean urlValid;
	   for (ResultPair i : testUrlScheme)
	   {
		   
		   for (ResultPair j : testUrlAuthority)
		   {
			   url = i.item + j.item;
			   urlValid = urlVal.isValid(url);
			   if ((i.valid && j.valid && urlValid) || ((!i.valid || !j.valid) && !urlValid))
			   {
				   // Tests pass if both components are valid and the url is valid
				   // OR
				   // if either of the components are invalid and the url is invalid
				   System.out.println("Passed: URL -> " + url + ". Expected: " + (i.valid && j.valid) + ". Actual: " + urlValid);
			   }
			   else
			   {
				   System.out.println("Passed: URL -> " + url + ". Expected: " + (i.valid && j.valid) + ". Actual: " + urlValid);
			   }
//			   System.out.println(url);
		   }
	   }
   }
   
   ResultPair[] testUrlScheme = {
		   	new ResultPair("http://", true),
	        new ResultPair("https://", true),
	        new ResultPair("ftp://", true),
	        new ResultPair("blah://", false),
	        };
   
   ResultPair[] testUrlAuthority = {
		   	new ResultPair("www.google.com", true),
	        new ResultPair("google.com", true),	        
	        };
}