def User_rating_test1_pdf():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Users Rating' item of the 'panel' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.ClickItem("Users Rating")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report3Jsp.Wait()
    #Clicks at point (208, 12) of the 'selectReport3SelectRating' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.selectReport3SelectRating.Click(208, 12)
    #Selects the 'low rated' item of the 'selectReport3SelectRating' combo box.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.selectReport3SelectRating.ClickItem("low rated")
    #Clicks at point (139, 9) of the 'numberinputReport3Number' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.numberinputReport3Number.Click(139, 9)
    #Enters '00' in the 'numberinputReport3Number' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.numberinputReport3Number.Keys("00")
    #Clicks at point (33, 5) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.textnode.Click(33, 5)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_2' button.
    Aliases.browser.dlg_.btn_2.ClickButton()
