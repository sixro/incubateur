.PHONY: all validate test

all: validate test

validate:
	@echo ""
	@echo "--  Validating  --------------------------------------------------------"
	composer update

test:
	@echo ""
	@echo "--  Testing  -----------------------------------------------------------"
	phpunit
