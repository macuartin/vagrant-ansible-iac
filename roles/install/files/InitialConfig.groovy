#!/usr/bin/env groovy

import jenkins.model.*
import hudson.security.*


def instance = Jenkins.get()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('macuartin','admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.save()
