local num = redis.call('exists',KEYS[1])
if tonumber(num) == 1 then
    return 'exists'
else
    redis.call('set',KEYS[1],KEYS[2])
    return 'not exists'
end