# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  config.vm.define "jenkins" do |jenkins|

    # OS Configuration
    jenkins.vm.box = "centos/7"

    #Network configuraions
    jenkins.vm.network "public_network", ip: "192.168.0.100"

    # Hardware configurations
      jenkins.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.memory = "1024"
    end

    config.vm.provision "ansible" do |ansible|
      ansible.playbook = "playbook.yaml"
    end

  end

  config.vm.define "dev" do |dev|

    # OS Configuration
    dev.vm.box = "centos/7"

    #Network configuraions
    dev.vm.network "public_network", ip: "192.168.0.101"

    # Hardware configurations
    dev.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.memory = "1024"
    end

  end


  config.vm.define "qa" do |qa|

    # OS Configuration
    qa.vm.box = "centos/7"

    #Network configuraions
    qa.vm.network "public_network", ip: "192.168.0.102"

    # Hardware configurations
    qa.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.memory = "1024"
    end

  end

end
