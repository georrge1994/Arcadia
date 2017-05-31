def Course_test_test1_pdf():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Courses Tests' item of the 'panel2' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel2.ClickItem("Courses Tests")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report5Jsp.Wait()
    #Clicks at point (20, 10) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report5Jsp.formReport5Form.textnode.Click(20, 10)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
