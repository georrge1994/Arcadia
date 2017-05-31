def Course_test_test2_xml():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Courses Tests' item of the 'panel2' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel2.ClickItem("Courses Tests")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report5Jsp.Wait()
    #Clicks at point (24, 6) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report5Jsp.formReport5Form.panel.panel.Click(24, 6)
    #Clicks at point (17, 4) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report5Jsp.formReport5Form.textnode.Click(17, 4)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
