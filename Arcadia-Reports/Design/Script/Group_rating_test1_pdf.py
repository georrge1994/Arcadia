def Group_rating_test1_pdf():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Group Rating' item of the 'panel' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.ClickItem("Group Rating")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report4Jsp.Wait()
    #Clicks at point (29, 4) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report4Jsp.formReport4Form.textnode.Click(29, 4)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
