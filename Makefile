BUILD_DIR     = build
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_TEST      = src/test

TOOL_DIR      = tools
LIB_DIR       = lib

CS_AST_VERSION = 0.1.2
CS_AST_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ast.jar
CS_AST_URL     = https://github.com/x96-sys/cs.ast.java/releases/download/v$(CS_AST_VERSION)/org.x96.sys.foundation.cs.ast.jar

CS_IR_VERSION = 0.1.2
CS_IR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ir.jar
CS_IR_URL     = https://github.com/x96-sys/cs.ir.java/releases/download/v$(CS_IR_VERSION)/org.x96.sys.foundation.cs.ir.jar

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar

JACOCO_VERSION = 0.8.13
JACOCO_BASE    = https://maven.org/maven2/org/jacoco

JACOCO_CLI_VERSION = $(JACOCO_VERSION)
JACOCO_CLI_JAR     = $(TOOL_DIR)/jacococli.jar
JACOCO_CLI_URL     = $(JACOCO_BASE)/org.jacoco.cli/$(JACOCO_CLI_VERSION)/org.jacoco.cli-$(JACOCO_CLI_VERSION)-nodeps.jar

JACOCO_AGENT_VERSION = $(JACOCO_VERSION)
JACOCO_AGENT_JAR     = $(TOOL_DIR)/jacocoagent-runtime.jar
JACOCO_AGENT_URL     = $(JACOCO_BASE)/org.jacoco.agent/$(JACOCO_AGENT_VERSION)/org.jacoco.agent-$(JACOCO_AGENT_VERSION)-runtime.jar

GJF_VERSION = 1.28.0
GJF_JAR     = $(TOOL_DIR)/google-java-format.jar
GJF_URL     = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar

JAVA_SOURCES      = $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES = $(shell find $(SRC_TEST) -name "*.java")

DISTRO_JAR = org.x96.sys.foundation.cs.ast2ir.jar

CP = $(CS_AST_JAR):$(CS_IR_JAR)

$(LIB_DIR) $(TOOL_DIR):
	@mkdir -p $@

build: lib/ast lib/ir
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "✅ Compilação concluída com sucesso!"

build-test: build tools/junit
	@javac -d $(TEST_BUILD) -cp $(MAIN_BUILD):$(JUNIT_JAR):$(CP) $(JAVA_TEST_SOURCES)
	@echo "✅ Compilação de testes concluída com sucesso!"

test: build-test
	@java -jar $(JUNIT_JAR) \
     execute \
     --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
     --scan-class-path

coverage-run: build-test tools/jacoco
	@java -javaagent:$(JACOCO_AGENT_JAR)=destfile=$(BUILD_DIR)/jacoco.exec \
       -jar $(JUNIT_JAR) \
       execute \
       --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
       --scan-class-path

coverage-report: tools/jacoco
	@java -jar $(JACOCO_CLI_JAR) report \
     $(BUILD_DIR)/jacoco.exec \
     --classfiles $(MAIN_BUILD) \
     --sourcefiles $(SRC_MAIN) \
     --html $(BUILD_DIR)/coverage \
     --name "Coverage Report"

coverage: coverage-run coverage-report
	@echo "✅ Relatório de cobertura disponível em: build/coverage/index.html"
	@echo "🌐 Abrir com: open build/coverage/index.html"

format: tools/gjf ## Formata todo o código fonte Java com google-java-format
	find src -name "*.java" -print0 | xargs -0 java -jar $(GJF_JAR) --aosp --replace

distro:
	@jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .
	@echo "✅ Distribuição criada com sucesso! $(DISTRO_JAR)"

define deps
$1/$2: $1
	@if [ ! -f "$$($3_JAR)" ]; then \
		echo "[📦] [🚛] [$$($3_VERSION)] [$2]"; \
		curl -sSL -o $$($3_JAR) $$($3_URL); \
	else \
		echo "[📦] [✅] [$$($3_VERSION)] [$2]"; \
	fi
endef

$(eval $(call deps,lib,ast,CS_AST))
$(eval $(call deps,lib,ir,CS_IR))
tools/jacoco: tools/jacoco_cli tools/jacoco_agent
$(eval $(call deps,tools,junit,JUNIT))
$(eval $(call deps,tools,jacoco_cli,JACOCO_CLI))
$(eval $(call deps,tools,jacoco_agent,JACOCO_AGENT))
$(eval $(call deps,tools,gjf,GJF))

clean:
	@rm -rf $(BUILD_DIR) $(TOOL_DIR) $(LIB_DIR)
	@echo "[🧹] [clean] Build directory cleaned."
