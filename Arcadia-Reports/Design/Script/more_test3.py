def more_test3():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks an item of the 'buttonMore' drop-down control.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.panel.buttonMore.ClickItem("Users Rating")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report3Jsp.Wait()
    #Checks whether the 'idStr' property of the Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form object equals ''.
    aqObject.CheckProperty(Aliases.browser.pageLocalhost8080Report3Jsp.formReport3Form, "idStr", cmpEqual, "")
