# appsec-public-test

Repository used for testing things related to Github permissions.

## PoC: base image traceability without a pinned SHA in the Dockerfile

The Dockerfile names the base image and tag only (`FROM …:tag`). The
[workflow](.github/workflows/base-image-traceability.yaml) resolves the tag's
current SHA with `crane digest`, pins it into the `FROM` line of the checked-out
copy so the build uses exactly that SHA, and records it in three places:

| Option | Where | How to read it |
|---|---|---|
| Step summary | GitHub Actions run | Full `image:tag@sha256:…` |
| A: annotation | Nais `Application` | `kubectl get app appsec-public-test -n appsec-workshop -o jsonpath='{.metadata.annotations.base-image-reference}'` |
| B: labels | Application, Deployment and pods | `kubectl get pods -n appsec-workshop -l app=appsec-public-test -L base-image-tag,base-image-sha256-first,base-image-sha256-last` |

Annotations hold the full reference but Nais does not propagate them to pods.
Labels reach the pods, but values are limited to 63 characters, so the 64-character
SHA-256 is split in two halves; concatenate `first` + `last` to get the full hash.


