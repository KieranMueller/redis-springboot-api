# Current Issues

- Products being saved through POST method currently need explicit unique ID, they are not being auto-generated/incremented.
  Posted product will overwrite existing product with same ID
- Figure out how to cache GET all method? Will need to cacheput any creation methods

# Current Functionality
- GET all products
- GET product by ID (Cacheable)
- POST new product (must send unique ID in json or it will overwrite existing product)
- DELETE product by ID (CacheEvict)