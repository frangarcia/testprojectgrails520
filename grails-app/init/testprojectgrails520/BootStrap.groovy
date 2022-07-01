package testprojectgrails520

import com.cheetahdigital.account.Account
import com.cheetahdigital.account.Subaccount

class BootStrap {

    def init = { servletContext ->
        Account account1 = new Account(name:"my first account").save()
        Class clazz = Subaccount.classLoader.loadClass(Subaccount.class.name)
        Map m1 = new HashMap(account1.properties as Map)
        m1.put("id", account1.id)
        println "*"*100
        println "account.id = ${account1.id}"
        println "account1.properties as Map = ${account1.properties as Map}"
        println "m1 = ${m1}"
        println "*"*100
        Subaccount subaccount = clazz.getDeclaredConstructor(Map.class).newInstance(m1) as Subaccount;
        println "*"*100
        println "Subaccount.id before saving = ${subaccount.id}"
        subaccount.save()
        println "Subaccount.id after saving = ${subaccount.id}"
        println "*"*100
    }
    def destroy = {
    }
}
