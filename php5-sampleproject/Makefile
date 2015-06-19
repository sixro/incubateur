.PHONY: all validate test

all: validate test

validate:
	@echo ""
	@echo "--  Validating  --------------------------------------------------------"
	composer install

test:
	@echo ""
	@echo "--  Testing  -----------------------------------------------------------"
	phpunit
