<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 100%;
                    }

                    th, td {
                    padding: 8px;
                    text-align: left;
                    border-bottom: 1px solid #DDD;
                    }

                    tr:hover {background-color: #D6EEEE;}
                </style>
            </head>
            <body>
                <div>
                    <h2>Library: <xsl:value-of select="library/name"/>, <xsl:value-of
                            select="library/address"/>,
                        <xsl:value-of select="library/workHours"/>
                    </h2>
                </div>
                <div>
                    <h3>Librarian:</h3>
                    <ul style="list-style-type: square">
                        <li><i>First Name</i>:
                            <xsl:value-of select="library/librarian/name"/>
                        </li>
                        <li><i>Last Name</i>:
                            <xsl:value-of select="library/librarian/lastName"/>
                        </li>
                        <li><i>Phone Number</i>:
                            <xsl:value-of
                                    select="library/librarian/phoneNumber"/>
                        </li>
                        <li><i>Email</i>:
                            <xsl:value-of select="library/librarian/email"/>
                        </li>
                    </ul>
                </div>

                <div>

                    <h2>Subscribers</h2>
                    <table border="1">
                        <tr bgcolor="#aba3a2">
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Borrowing</th>
                        </tr>
                        <xsl:for-each select="library/subscribers/subscriber">
                            <tr>
                                <td>
                                    <xsl:value-of select="id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="name"/>
                                </td>
                                <td>
                                    <xsl:value-of select="lastName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="address"/>
                                </td>
                                <td>
                                    <xsl:value-of select="email"/>
                                </td>
                                <td>
                                    <xsl:value-of select="phone"/>
                                </td>
                                <td>
                                    <xsl:for-each select="borrowings/borrowing">
                                        <p>
                                            <b>From</b>:
                                            <xsl:value-of select="borrowDate"/> -
                                            <b>To</b>:
                                            <xsl:value-of select="returnDate"/>
                                            <br/>
                                            <b>Item</b>: <xsl:value-of
                                                select="item/title"/>, <xsl:value-of
                                                select="item/author"/>, <xsl:value-of
                                                select="item/publisher"/>,
                                            <xsl:value-of
                                                    select="item/productionYear"/>
                                        </p>
                                    </xsl:for-each>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>


                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>