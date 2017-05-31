def Period_test1_pdf():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks at point (195, 11) of the 'panel' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.panel.panel.Click(195, 11)
    #Clicks at point (17, 11) of the 'cell' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel.table.cell.Click(17, 11)
    #Clicks at point (194, 13) of the 'panel' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.panel2.panel.Click(194, 13)
    #Clicks at point (16, 13) of the 'cell2' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel.table.cell2.Click(16, 13)
    #Clicks at point (38, 12) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.textnode.Click(38, 12)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
