def Course_test1_pdf():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Course' item of the 'panel' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.ClickItem("Course")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report2Jsp.Wait()
    #Clicks at point (192, 12) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.panel.panel.Click(192, 12)
    #Clicks at point (21, 16) of the 'cell' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.panel.panel.table.cell.Click(21, 16)
    #Clicks at point (192, 13) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.panel2.panel.Click(192, 13)
    #Clicks at point (22, 20) of the 'cell' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.panel2.panel.table.cell.Click(22, 20)
    #Clicks at point (36, 9) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.textnode.Click(36, 9)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
