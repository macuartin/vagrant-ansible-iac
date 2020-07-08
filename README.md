# devops-ansible-vm-jenkins

> Playbook de Ansible que permite la instalación de Jenkins en una o mas maquinas virtuales especificadas. Este playbook puede ser usado por Vagrant y Packer como provisioner.

## Tabla de Contenido

- [Prerequisitos](#prerequisites)
- [Instalación](#installation)
- [Quickstart](#quickstart)
- [Contributing](#contributing)
- [Further Reading / Useful Links](#further-reading--useful-links)

## Prerequisites

Necesitaras tener instalado los siguientes componentes en tu computadora.

* [Ansible](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html)
* [Python](https://www.python.org/downloads/)
* [Vagrant](https://www.vagrantup.com/docs/installation)

Necesitaras tener instalado los siguientes componentes en la maquina remota.

* [Python](https://www.python.org/downloads/)

## Installation

* Clona este repositorio

```bash
$ git clone git@github.com:AvalCoeDevOps/devops-ansible-vm-jenkins.git
```

* Ve a la carpeta devops-ansible-vm-jenkins

```bash
$ cd devops-ansible-vm-jenkins
```

## Quickstart

### Quickstart VM

Si la maquina virtual ya esta aprovisionada solo necesitas ejecutar el siguiente comando desde un computador que tenga instalado ansible y que tenga acceso a la maquina que quieres configurar

```bash
ansible-playbook -i ./inventories/hosts playbook.yml
```

Asegurate que en el archivo hosts este la ip de la maquin a ser configurada.

### Quickstart Vagrant

* Para usar este playbook como provisioner en Vagrant debes adicionar las siguientes lineas a tu Vagrantfile:

```ruby
config.vm.provision "ansible" do |ansible|
  ansible.playbook = "./playbook.yaml"
  ansible.inventory_path = "./inventories/hosts"
end
```

* Asegurarse que en el archivo hosts que se encuentra en "./inventories/hosts" este la ip de la maquina a ser aprovisionada en el grupo "default"


### Quickstart Packer

* Para usar este playbook como provisioner en Packer debes adicionar las siguientes sección a tu Packer Template:

```json
"provisioners": [
  {
    "type": "ansible",
    "playbook_file": "./playbook.yml",
    "use_proxy": false
  }
]
```

## Contributing

If you find this repo useful here's how you can help:

1. Send a Pull Request with your awesome new features and bug fixes
2. Wait for a Coronita :beer: you deserve it.

## Further Reading / Useful Links

* [Packer Ansible Provisioner](https://www.packer.io/docs/provisioners/ansible.html)
* [Vagrant Ansible Provisioner](https://www.vagrantup.com/docs/provisioning/ansible.html)
