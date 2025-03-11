# ansible facts
facts

### running the play
```
$>  ansible-playbook -i hosts.ini  -e '{ "target_hosts": "local.io" }'  facts-play.yml

PLAY [play facts] ***************************************************************************************

TASK [display the dictonary] ****************************************************************************
ok: [local.io] => {
    "hList": [
        {
            "name": "lorem",
            "value": "ipsum"
        },
        {
            "name": "foo",
            "value": "bar"
        },
        {
            "name": "tempus",
            "value": "fugit"
        }
    ]
}

TASK [set keys as facts] ********************************************************************************
ok: [local.io] => (item={'name': 'lorem', 'value': 'ipsum'})
ok: [local.io] => (item={'name': 'foo', 'value': 'bar'})
ok: [local.io] => (item={'name': 'tempus', 'value': 'fugit'})

TASK [check fact_lorem] *********************************************************************************
ok: [local.io] => {
    "msg": "ipsum"
}

TASK [check fact_foo] ***********************************************************************************
ok: [local.io] => {
    "msg": "bar"
}

TASK [check fact_tempus] ********************************************************************************
ok: [local.io] => {
    "msg": "fugit"
}

PLAY RECAP **********************************************************************************************
local.io                   : ok=5    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0

```
