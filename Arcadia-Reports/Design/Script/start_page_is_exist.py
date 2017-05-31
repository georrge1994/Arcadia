def start_page_is_exist():
    #Runs the "http___localhost_8080_report_designer" tested application.
    TestedApps.http___localhost_8080_report_designer.Run()
    #Opens the specified URL in a running instance of the specified browser.
    Browsers.Item[btChrome].Navigate("http://localhost:8080/report_designer")
    #Checks whether the 'idStr' property of the Aliases.browser.pageLocalhost8080ReportDesigner.panel object equals ''.
    aqObject.CheckProperty(Aliases.browser.pageLocalhost8080ReportDesigner.panel, "idStr", cmpEqual, "")
    #Checks whether the 'idStr' property of the Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form object equals 'report1_form'.
    aqObject.CheckProperty(Aliases.browser.pageLocalhost8080ReportDesigner.panel.formReport1Form, "idStr", cmpEqual, "report1_form")
    #Checks whether the 'idStr' property of the Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.imageReport1PdfPng object equals ''.
    aqObject.CheckProperty(Aliases.browser.pageLocalhost8080ReportDesigner.panel.panel2.imageReport1PdfPng, "idStr", cmpEqual, "")
