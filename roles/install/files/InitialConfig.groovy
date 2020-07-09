#!/usr/bin/env groovy

import jenkins.model.*
import hudson.security.*


def instance = Jenkins.get()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
<<<<<<< HEAD
hudsonRealm.createAccount('admin','admin')
=======
hudsonRealm.createAccount('macuartin','admin')
>>>>>>> 8264ddb9290af624f0a79eaa0157fe645f41849a
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.save()
