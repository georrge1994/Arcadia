def Period_test2_xml():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Clicks at point (192, 7) of the 'panel' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.panel.panel.Click(192, 7)
    #Clicks at point (16, 20) of the 'cell' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel.table.cell.Click(16, 20)
    #Clicks at point (195, 18) of the 'panel' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.panel2.panel.Click(195, 18)
    #Clicks at point (15, 8) of the 'cell2' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel.table.cell2.Click(15, 8)
    #Clicks at point (16, 8) of the 'panel2' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.panel2.Click(16, 8)
    #Clicks at point (24, 10) of the 'textnode' object.
    Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form.textnode.Click(24, 10)
    #Checks whether the 'Enabled' property of the Aliases.browser.dlg_ object equals True.
    aqObject.CheckProperty(Aliases.browser.dlg_, "Enabled", cmpEqual, True)
    #Clicks the 'btn_' button.
    Aliases.browser.dlg_.btn_.ClickButton()
