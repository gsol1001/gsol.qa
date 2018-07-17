set myProjectpath=C:\Selenium\workspace\gsol.qa
cd %myProjectpath%
set classpath=%myProjectpath%\bin;%myProjectpath%\JarFiles\*
java org.testng.TestNG %myProjectpath%\testng.xml