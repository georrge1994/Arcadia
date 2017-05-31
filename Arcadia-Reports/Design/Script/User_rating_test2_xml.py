def User_rating_test2_xml():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Users Rating' item of the 'panel' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.ClickItem("Users Rating")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report3Jsp.Wait()
    #Clicks at point (114, 11) of the 'numberinputReport3Number' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.numberinputReport3Number.Click(114, 11)
    #Enters '120' in the 'numberinputReport3Number' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.numberinputReport3Number.Keys("120")
    #Clicks at point (19, 13) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.panel.panel.Click(19, 13)
    #Clicks at point (48, 11) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form.textnode.Click(48, 11)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
