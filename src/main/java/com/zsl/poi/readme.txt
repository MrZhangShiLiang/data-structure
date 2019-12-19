* 此文件夹用于生成office文档相关，word，excel，ppt
* poi官网：http://poi.apache.org/components/
* 所需相关jar包如下表

Component	Application type	        Maven artifactId	            Notes
POIFS	    OLE2 Filesystem	            poi	                            Required to work with OLE2 / POIFS based files
HPSF	    OLE2 Property Sets	        poi
HSSF	    Excel XLS	                poi	                            For HSSF only, if common SS is needed see below
HSLF	    PowerPoint PPT	            poi-scratchpad
HWPF	    Word DOC	                poi-scratchpad
HDGF	    Visio VSD	                poi-scratchpad
HPBF	    Publisher PUB	            poi-scratchpad
HSMF	    Outlook MSG	                poi-scratchpad
DDF	        Escher common drawings	    poi
HWMF	    WMF drawings	            poi-scratchpad
OpenXML4J	OOXML	                    poi-ooxml plus either poi-ooxml-schemas or ooxml-schemas and ooxml-security，
                                            See notes below for differences between these options
XSSF	    Excel XLSX	                poi-ooxml
XSLF	    PowerPoint PPTX	            poi-ooxml
XWPF	    Word DOCX	                poi-ooxml
XDGF	    Visio VSDX	                poi-ooxml
Common SL	PowerPoint PPT and PPTX	    poi-scratchpad and poi-ooxml	SL code is in the core POI jar, but implementations are in poi-scratchpad and poi-ooxml.
Common SS	Excel XLS and XLSX	        poi-ooxml	                    WorkbookFactory and friends all require poi-ooxml, not just core poi



by zsl.