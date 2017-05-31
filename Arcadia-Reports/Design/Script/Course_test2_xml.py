def Course_test2_xml():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks the 'Course' item of the 'panel' bar.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel.ClickItem("Course")
    #Waits until the browser loads the page and is ready to accept user input.
    Aliases.browser.pageLocalhost8080Report2Jsp.Wait()
    #Clicks at point (191, 17) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.panel.panel.Click(191, 17)
    #Clicks at point (15, 20) of the 'cell' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.panel.panel.table.cell.Click(15, 20)
    #Clicks at point (195, 13) of the 'panel' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.panel2.panel.Click(195, 13)
    #Clicks at point (17, 11) of the 'cell' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.panel2.panel.table.cell.Click(17, 11)
    #Drags from point (9, 15) of the 'panel' object to offset (-82, -5).
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.panel.Drag(9, 15, -82, -5)
    #Clicks at point (52, 18) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080Report2Jsp.formReport2Form.textnode.Click(52, 18)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
