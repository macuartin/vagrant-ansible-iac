#!/usr/bin/env groovy

import jenkins.model.*
def installed = false
def initialized = false
def pluginParameter="configuration-as-code docker-workflow ant build-timeout credentials-binding email-ext github-organization-folder gradle workflow-aggregator ssh-slaves git timestamper ws-cleanup"
def plugins = pluginParameter.split()
def instance = Jenkins.getInstance()
def pm = instance.getPluginManager()
def uc = instance.getUpdateCenter()

plugins.each {
  
  if (!pm.getPlugin(it)) {
    if (!initialized) {
      uc.updateAllSites()
      initialized = true
    }
    def plugin = uc.getPlugin(it)
    if (plugin) {
    	def installFuture = plugin.deploy()
      while(!installFuture.isDone()) {
        sleep(1000)
      }
      installed = true
    }
  }
}

if (installed) {
  instance.save()
  instance.restart()
}
