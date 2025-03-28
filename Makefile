.DEFAULT_GOAL := help

.PHONY: help
help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

## Lints
.PHONY: lint
lint: ## Runs Clean and ktlintFormat and ktlintCheck tasks
	./gradlew clean ktlintFormat ktlintCheck
	
create-module:
	mkdir -p features/$(name)
	cp features/dogs/build.gradle.kts features/$(name)/build.gradle.kts
	echo "\ninclude(\":features:$(name)\")" >> includes.gradle.kts