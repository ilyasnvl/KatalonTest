import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('login'), [('username') : 'standard_user', ('password') : 'secret_sauce'], FailureHandling.STOP_ON_FAILURE)

expectedPrice = WebUI.getText(findTestObject('add_cart/price', [('text') : '$29.99']))
//WebUI.getText(findTestObject('add_cart/price'), expectedPrice)

WebUI.click(findTestObject('add_cart/btn_add_to_cart'))

WebUI.click(findTestObject('add_cart/btn_add_cart_lampu'))

//WebUI.verifyMatch(actualPrice, expectedPrice, false)
WebUI.verifyElementText(findTestObject('add_cart/price'), expectedPrice)

WebUI.click(findTestObject('add_cart/icon_cart'))

//WebUI.verifyElementText(findTestObject('add_cart/priceCart'), expectedPrice)
hargaCart = WebUI.getText(findTestObject('add_cart/priceCart'))

WebUI.verifyMatch(hargaCart, expectedPrice, false)

WebUI.click(findTestObject('add_cart/btn_checkout'))

WebUI.setText(findTestObject('add_cart/field_firstname'), 'ilyas')

WebUI.setText(findTestObject('add_cart/field_lastname'), 'test')

WebUI.setText(findTestObject('add_cart/field_postal_code'), '123')

WebUI.click(findTestObject('add_cart/btn_continue'))

WebUI.verifyElementText(findTestObject('add_cart/priceCheckout'), expectedPrice)

item = WebUI.getText(findTestObject('add_cart/priceTotal'))

WebUI.verifyElementText(findTestObject('add_cart/priceTotal'), item)

WebUI.click(findTestObject('add_cart/btn_finish'))

WebUI.verifyElementText(findTestObject('add_cart/exp_order_text'), 'Thank you for your order!')

WebUI.verifyElementVisible(findTestObject('add_cart/btn_back_home'))

WebUI.closeBrowser()


