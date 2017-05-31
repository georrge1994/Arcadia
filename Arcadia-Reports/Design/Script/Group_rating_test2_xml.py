def Group_rating_test2_xml():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Group Rating' item of the 'panel2' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel2.ClickItem("Group Rating")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report4Jsp.Wait()
    #Clicks at point (16, 8) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report4Jsp.formReport4Form.panel.panel.Click(16, 8)
    #Clicks at point (12, 1) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report4Jsp.formReport4Form.textnode.Click(12, 1)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_2' button.
    Aliases.browser.dlg_.btn_2.ClickButton()
