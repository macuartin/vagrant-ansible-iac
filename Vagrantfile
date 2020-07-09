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

end
