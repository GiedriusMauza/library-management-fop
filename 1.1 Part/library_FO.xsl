<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="library">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" font-family="Arial">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm">Library:
                        <xsl:value-of select="concat(name, ', ')"/>
                        <xsl:value-of select="concat(address, ', ')"/>
                        <xsl:value-of select="concat('From-to: ' ,workHours, ' h')"/>
                    </fo:block>
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm">Librarian:
                        <xsl:value-of select="concat(librarian/name, ', ')"/>
                        <xsl:value-of select="concat(librarian/lastName, ', ')"/>
                        <xsl:value-of select="concat(librarian/email, ', ')"/>
                        <xsl:value-of select="librarian/phoneNumber"/>
                    </fo:block>
                    <fo:block font-size="18pt" font-weight="bold" margin-top="1cm" margin-bottom="0.5cm">Subscribers:
                    </fo:block>
                    <fo:block margin-bottom="0.5cm"></fo:block>
                    <xsl:for-each select="subscribers/subscriber">
                        <fo:block font-size="14pt" font-weight="bold" margin-bottom="0.5cm">
                            <xsl:value-of select="concat(name, ' ', lastName)"/>
                        </fo:block>
                        <fo:block margin-bottom="0.2cm">
                            <xsl:value-of select="concat('Address: ', address)"/>
                        </fo:block>
                        <fo:block margin-bottom="0.2cm">
                            <xsl:value-of select="concat('Email: ', email)"/>
                        </fo:block>
                        <fo:block margin-bottom="0.2cm">
                            <xsl:value-of select="concat('Phone: ', phone)"/>
                        </fo:block>
                        <fo:block margin-bottom="0.1cm" font-weight="bold">Borrowings:</fo:block>
                        <xsl:for-each select="borrowings/borrowing">
                            <fo:block>
                                <fo:block margin-top="0.2cm" margin-left="0.5cm">
                                    <xsl:value-of select="concat('Borrow Date: ', borrowDate, ' - ')"/>
                                    <xsl:value-of select="concat('Return Date: ', returnDate)"/>
                                </fo:block>
                                <xsl:for-each select="item">
                                    <fo:block margin-left="0.5cm">
                                        <fo:block>
                                            <xsl:value-of select="concat('Author: ', author)"/>
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="concat('Title: ', title)"/>
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="concat('Publisher: ', publisher)"/>
                                        </fo:block>
                                        <fo:block>
                                            <xsl:value-of select="concat('Production Year: ', productionYear)"/>
                                        </fo:block>
                                    </fo:block>
                                </xsl:for-each>
                            </fo:block>
                        </xsl:for-each>
                        <fo:block margin-bottom="0.5cm"></fo:block>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>