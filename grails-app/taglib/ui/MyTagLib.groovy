package ui

import groovy.xml.MarkupBuilder

class MyTagLib {

    static namespace = "myui"

    Closure c1 = {

        MarkupBuilder mb = new MarkupBuilder( out )

        mb.p {
            mb.yield(c4([text:"using c4()"]).toString(), false)
        }
    }

    Closure c2 = {

        MarkupBuilder mb = new MarkupBuilder( out )

        mb.p {
            mb.yield(this.c4([text:"using this.c4()"]).toString(), false)
        }
    }

    Closure c3 = {

        MarkupBuilder mb = new MarkupBuilder( out )

        mb.p {
            mb.yield(myui.c4([text:"using myui.c4()"]).toString(), false)
        }
    }



    Closure c4 = { attrs ->
        MarkupBuilder mb = new MarkupBuilder( out )

        mb.span(attrs.text)
    }
}